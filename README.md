开发工具：IntelliJ IDE

建模工具：ProcessOn

数据库服务器：MySQL

Web服务器：Tomcat

开发模式：MVC

框架：Spring、Bootstrap

数据库连接池：Druid

实现一个住房公积金管理系统，主要包括相关客户信息（单位开户、个人开户、单位资料修改、个人资料修改）管理、业务查询（单位查询、个人查询）以及销户（个人销户、单位销户）等功能（其他的还没实现，像批量开户，这个我觉得需要用到事务，事务我还不熟，所以，就鸽了，哈哈）。  

# 一、27号进度

登录功能

* 账号密码报错提示
* 验证码报错提示

![](https://meethigher.top/blog/2020/house-fund/1.png)

# 二、28号进度

今天上午家里升级宽带，由50M网线升级成了100M光纤，一年360。交了13个月的，收了400，应该10块钱是安装费了。50M的时候，封顶能跑个2m/s，现在能跑个4m/s，用的铁通宽带，是真的有点垃圾。

说说今天进度。

1. 登录功能：
   * 顶号处理（通过ServletContext设置username为键，sessionid为值，登录时，会自动更新，判断当前的username的sessionid是否与获取的一致。若一致，登录成功；否则，登录失败）
2. 修改管理员密码功能：
   * 修改结果提示

通过jsp获取当前页面，来决定哪个标签是active

总览页面

![](https://meethigher.top/blog/2020/house-fund/2.png)

单位页面

![](https://meethigher.top/blog/2020/house-fund/3.png)

# 三、29号进度

完成功能：

1. 优化登录验证码
2. 单位开户页面：
   * 类型输入框采用下拉菜单
   * 部分输入限制，采用[js正则表达式](https://blog.csdn.net/sirobot/article/details/101030392)，注册按键松开事件，用正则替换掉不符要求的内容
3. 单位开户

![](https://meethigher.top/blog/2020/house-fund/4.png)

# 四、7号进度

完成功能：

1. 个人开户：添加用户，需要更新单位表下的人数、单位月缴总额和个人月缴总额的数据。有两个思路
   * 代码完成
   * MySQL触发器

![](https://meethigher.top/blog/2020/house-fund/7.png)

我采用的MySQL触发器，[学习地址](https://www.cnblogs.com/phpper/p/7587031.html)

```sql
create trigger insert_trigger after insert on tb003 for EACH row
begin
update tb002 as a join (select unitaccnum,sum(basenumber) sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.basenumber=b.sum;
update tb002 as a join (select unitaccnum,sum(unitmonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.unitpaysum=b.sum;
update tb002 as a join (select unitaccnum,sum(permonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.perpaysum=b.sum;
update tb002 as a join (select unitaccnum,count(accnum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.persnum=b.sum;
end

create trigger update_trigger after UPDATE on tb003 for EACH row
begin
update tb002 as a join (select unitaccnum,sum(basenumber) sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.basenumber=b.sum;
update tb002 as a join (select unitaccnum,sum(unitmonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.unitpaysum=b.sum;
update tb002 as a join (select unitaccnum,sum(permonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.perpaysum=b.sum;
update tb002 as a join (select unitaccnum,count(accnum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.persnum=b.sum;
end

create trigger delete_trigger after DELETE on tb003 for EACH row
begin
update tb002 as a join (select unitaccnum,sum(basenumber) sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.basenumber=b.sum;
update tb002 as a join (select unitaccnum,sum(unitmonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.unitpaysum=b.sum;
update tb002 as a join (select unitaccnum,sum(permonpaysum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.perpaysum=b.sum;
update tb002 as a join (select unitaccnum,count(accnum) as sum from tb003 where peraccstate=0 GROUP BY unitaccnum) as b on a.unitaccnum=b.unitaccnum set a.persnum=b.sum;
end
```

# 五、8号进度

完成功能：

1. 单位修改
2. 个人修改
   * 反显数据
   * 多表连接查询

多表连接查询的时候，我直接懵了。

需求是查个人数据的时候，需要将单位的数据一并反显出来。

我一开始是想查询两次，封装成Javabean，存储session。但是太麻烦了，就百度了一下，[数据库采用多表连接查询，对应javaBean文件连接方式](https://www.cnblogs.com/chen-lhx/p/5002026.html)

# 六、9号进度

完成功能：

1. 单位查询
2. 个人查询
3. 单位销户
4. 个人销户

需要用到分页，思路就是，创建一个Page对象，里面存储当前页码，总页码，总条数，行数，以及存储bean对象的list集合

```java
public class Page<T> {
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private int rows;//每页显示记录数
    private List<T> list;//每页的数据
    
    ...getter and setter...
}
```

在jsp页面实现分页显示，类似于这样

![](https://meethigher.top/blog/2020/house-fund/8.png)

在jsp页面显示中，需要用到一个begin和end值，来求出其中的应该显示的条数。我在servlet中设置了这两个值

```java
//分页的开始跟结束
int visibility = 4;//设置分页中间显示的个数，4就表示中间有5个
int totalPage = personByPage.getTotalPage();
int current = personByPage.getCurrentPage();
current = current > totalPage ? totalPage : current;
current = current < 1 ? 1 : current;
int begin = current - visibility / 2;
int end = current + visibility / 2;
/**
 * 如果页数多于visibility，则按visibility正常显示
 * 如果页数少用visibility，则按实际情况展示
 */
if (totalPage > visibility) {
    begin = begin < 1 ? 1 : begin;
    end = begin + visibility;
    end = end > totalPage ? totalPage : end;
    begin = end - visibility;
} else {
    begin = begin < 1 ? 1 : begin;
    end = end > totalPage ? totalPage : end;
}
```

然后，在jsp页面中，通过jstl来控制生成页数

```jsp
<ul class="pagination pagination-sm pull-right mt-3">
    <li><a href="findPersonByPage?currentPage=1">首页</a></li>
    <c:forEach begin="${requestScope.begin}" end="${requestScope.end}" step="1" var="i">
        <li${requestScope.personByPage.currentPage==i?" class=\"active\"":""}><a href="findPersonByPage?currentPage=${i}">${i}</a></li>
    </c:forEach>
    <li><a href="findPersonByPage?currentPage=${requestScope.personByPage.totalPage}">尾页</a></li>
</ul>
```

本来还有几个功能，我看得很懵逼，问问老师，老师说不用实现了，那我就不客气了，下班，哈哈

![](https://meethigher.top/blog/2020/house-fund/9.png)

单位销户

![](https://meethigher.top/blog/2020/house-fund/10.png)

写完这些的时候，一看时间

![](https://meethigher.top/blog/2020/house-fund/6.png)

在使用过程中，还碰到了ssl的问题，解决方案[在这](https://blog.csdn.net/qq_38454176/article/details/104066348)