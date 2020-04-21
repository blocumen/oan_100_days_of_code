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
	
	if(mysrc === 'images/firefox-logo.png')
		myimage.setAttribute('src','images/firefox-logo2.png');
	else
		myimage.setAttribute('src','images/firefox-logo.png');
}
let bt = document.querySelector('button');
let myheading = document.querySelector('h1');
function setUsername()
{
	let myName = prompt("Please enter your name");
	 if(!myName || myName === null) {
    setUsername();
  } else {
    localStorage.setItem('name', myName);
    myheading.innerHTML = 'Mozilla is cool, ' + myName;
  }
	
}
if(!localStorage.getItem('name'))
{
	setUsername();
}
else
{
	let storedName = localStorage.getItem('name');
  myheading.textContent = 'Mozilla is cool, ' + storedName;
}
bt.onclick = function()
{
	//alert();
	setUsername();
}