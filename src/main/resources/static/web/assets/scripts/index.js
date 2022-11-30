new fullpage('#fullpage', {
    
    autoScrolling: true, 
    scrollingSpeed: 1000, 
    
    
    
    
})




const wordContainerEl1 = document.querySelector(".fachero-title1");
console.log(wordContainerEl1)
const word1 = wordContainerEl1.getAttribute("data-word");
console.log(word1)
const wordRepeatTimes1 = wordContainerEl1.getAttribute("data-word-repeat");
console.log(wordRepeatTimes1)
const textColorsArray1 = wordContainerEl1.getAttribute("data-text-colors").split(",");
console.log(textColorsArray1)

for (let i = 0; i < wordRepeatTimes1; i++) {
	const wordEl = document.createElement("span");
	wordEl.className = "word";
	wordEl.style.setProperty("--word-index", i);
	wordEl.style.setProperty("--color", textColorsArray1[i]);
	for (let j = 0; j < word1.length; j++) {
		const charEl = document.createElement("span");
		charEl.className = "char";
		charEl.style.setProperty("--char-index", j);
		charEl.innerHTML = word1[j];
		wordEl.appendChild(charEl);
	}
	wordContainerEl1.appendChild(wordEl);
}


const wordContainerEl2 = document.querySelector(".fachero-title2");
console.log(wordContainerEl2)
const word2 = wordContainerEl2.getAttribute("data-word");
console.log(word2)
const wordRepeatTimes2 = wordContainerEl2.getAttribute("data-word-repeat");
console.log(wordRepeatTimes2)
const textColorsArray2 = wordContainerEl2.getAttribute("data-text-colors").split(",");
console.log(textColorsArray2)

for (let i = 0; i < wordRepeatTimes2; i++) {
	const wordEl = document.createElement("span");
	wordEl.className = "word";
	wordEl.style.setProperty("--word-index", i);
	wordEl.style.setProperty("--color", textColorsArray2[i]);
	for (let j = 0; j < word2.length; j++) {
		const charEl = document.createElement("span");
		charEl.className = "char";
		charEl.style.setProperty("--char-index", j);
		charEl.innerHTML = word2[j];
		wordEl.appendChild(charEl);
	}
	wordContainerEl2.appendChild(wordEl);
}



const login1 = document.querySelector('.ingresar')
login1.addEventListener('click',function(){
   document.getElementById('ingreso_lateral').classList.toggle('activo');   
  
});




const login2 = document.querySelector('.registrarse')
login2.addEventListener('click',function(){
   document.getElementById('ingreso_lateral2').classList.toggle('activo');
});

function verificarPasswords(){
   password1=document.getElementById('password1');
   password2=document.getElementById('password2');

   if(password1.value != password2.value){
      document.getElementById('error').classList.add('mostrar');
      return false;
   }else{
      document.getElementById('error').classList.remove('mostrar');
      document.getElementById('ok').classList.remove('ocultar');
      document.getElementById('crear').disabled = true;
      return true;
   }
  

}

