$("#updateps").on("click",function (){
    let val=$("#newps").val().trim();
    if(val!=""){
        let href="updateAdmin?newps="+val;
        $(this).attr("href",href);
    }else{
        $(this).attr("#");
    }
});