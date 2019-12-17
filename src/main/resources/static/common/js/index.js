var imgs=document.getElementsByClassName("slide");
var spans=document.getElementsByClassName("page");
function InitMove(index){
    for(var i=0;i<imgs.length;i++){
        imgs[i].style.opacity='0';
        imgs[i].style.zIndex='1';
        spans[i].style.background='#ccc';
    }
    imgs[index].style.opacity='1';
    imgs[index].style.zIndex='3';
    spans[index].style.background='#12b7de';
}
InitMove(0);
var count=1;
function fMove(){
    if(count==imgs.length){
        count=0;
    }
    InitMove(count);
    count++;
}
setInterval(fMove,6500);



