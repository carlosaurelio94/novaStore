const inputs = document.querySelectorAll(".input-field");
const toggle_btn = document.querySelectorAll(".toggle");
const main = document.querySelector("main");
const contenedor = document.querySelector('.contenedor_general')
const colores =['#CB51EE','#0073BC','#38B75E','#DE365C']
const bullets = document.querySelectorAll(".bullets span");
const images = document.querySelectorAll(".image");

inputs.forEach((inp) => {
  inp.addEventListener("focus", () => {
    inp.classList.add("active");
  });
  inp.addEventListener("blur", () => {
    if (inp.value != "") return;
    inp.classList.remove("active");
  });
});

toggle_btn.forEach((btn) => {
  btn.addEventListener("click", () => {
    main.classList.toggle("sign-up-mode");
  });
});

function moveSlider() {
  let index = this.dataset.value;

  let currentImage = document.querySelector(`.img-${index}`);
  images.forEach((img) => img.classList.remove("show"));
  currentImage.classList.add("show");

  const textSlider = document.querySelector(".text-group");
  textSlider.style.transform = `translateY(${-(index - 1) * 2.2}rem)`;

  bullets.forEach((bull) => bull.classList.remove("active"));
  this.classList.add("active");
}

bullets.forEach((bullet) => {
  bullet.addEventListener("click", moveSlider);
});




const figuras = () =>{
  for(let i= 0; i <= 35; i++){
      let figura = document.createElement('span')
      let select = Math.round(colores.length * Math.random())     

      

      figura.style.top = innerHeight*Math.random() + 'px'
      figura.style.left = innerWidth*Math.random() + 'px'
      figura.style.background = colores[select >= colores.length ?  select -1: select]

      contenedor.appendChild(figura)

      setInterval(() =>{
          figura.style.top = innerHeight*Math.random() + 'px'
          figura.style.left = innerWidth*Math.random() + 'px'
      },2500)
  }
}

figuras()
