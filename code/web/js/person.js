$("#queryunit").on("click",function (){
    let val=$("#unitaccnum").val().trim();
    if(val!=""){
        let href="queryUnit?unitaccnum="+val;
        $(this).attr("href",href);
    }else{
        $(this).attr("#");
    }
});
$("#queryperson").on("click",function (){
    let val=$("#peraccnum").val().trim();
    if(val!=""){
        let href="queryPerson?accnum="+val;
        $(this).attr("href",href);
    }else{
        $(this).attr("#");
    }
});
