/*const myHeading = document.querySelector("h1");
myHeading.textContent = "Hello World!";
document.querySelector("html").onclick=function()
{
   alert('Ouch! stop pokig me!');
}*/
var myimage = document.querySelector("img");
myimage.onclick = function()
{
	let mysrc = myimage.getAttribute('src');
	
	if(mysrc === 'images/plain.jpg')
		myimage.setAttribute('src','images/greenary.jpg');
	else
		myimage.setAttribute('src','images/plain.jpg');
}
