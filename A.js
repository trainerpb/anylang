function demoRule1(x,y){
	return x+y;
}
/**
*  Additonal discount to women on
*  Sisters' Day
*/
function sistersDayDiscount(objStudent){

	return (objStudent.sex=="Female")? "30%":"20%";

}


