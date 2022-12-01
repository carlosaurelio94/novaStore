const { createApp } = Vue

createApp({
  data() {
    return {
      message: "Hola",
      email: "",
      password: "",
      firstName: "",
      lastName: "",
      emailRegistro: "",
      password1: "",
      password2: "",
      correoRegistro: ""
    }
  },
  created() {
  },
  mounted() {
  },
  methods: {
    iniciarSesion() {
      let email = this.email.toLowerCase();
      let password = this.password
      return axios.post('/api/login', `correo=${email}&clave=${password}`)
        .then(response => {
          window.location.assign("./productos.html")
        })
        .catch(function (error) {
          return Swal.fire({
            icon: "error",
            title: "Error " + error.response.status,
            text: "Ha ocurrido un error.",
            confirmButtonColor: '#ff4545',
/*             footer: '<a href="">Why do I have this issue?</a>'
 */          })
        })
    },
    registrarse() {
      let email = this.correoRegistro.toLowerCase()
      let password = this.password1
      let password2 = this.password2
      let firstName = this.firstName.toLowerCase()
      let lastName = this.lastName.toLowerCase()
      return axios.post('/api/clientes', `nombre=${firstName}&apellido=${lastName}&correo=${email}&clave=${password}&clave2=${password2}`)
      /*   .then(response => axios.post('/api/login', `correo=${email}&clave=${password}`))
        .then(res => {
          localStorage.setItem("cookie", "true")
        }) */
        .then(response => Swal.fire({
          text: 'Verifica tu buzón de correo electrónico',
          title: 'Antes de continuar',
          icon: 'success',
          confirmButtonColor: '#24cb24',
        }))
        .then(response => window.location.assign("./index.html"))
        .catch(function (error) {
          return Swal.fire({
            icon: "error",
            title: "Error " + error.response.status,
            text: error.response.data,
            confirmButtonColor: '#ff4545',
/*                 footer: '<a href="">Why do I have this issue?</a>'
 */              })
        })
    },
    changePassword() {
      let password = this.passwordChange
      return axios.patch('/api/clients/current', `password=${password}`).then(response => Swal.fire({
        title: 'Password changed succesfully',
        text: 'We have already deleted the previous one, this will now be your only password.',
        icon: 'success',
        confirmButtonColor: '#24cb24'
      })).then(response => window.location.assign("./accounts.html"))
        .catch(function (error) {
          return Swal.fire({
            icon: "error",
            title: "Error " + error.response.status,
            text: error.response.data,
            confirmButtonColor: '#ff4545',
/*                 footer: '<a href="">Why do I have this issue?</a>'
*/              })
        })
    },
    finalizarCompra() {
      
    },
    signUp() {
      let container = document.getElementById('container');
      return container.classList.add("right-panel-active")
    },
    signIn() {
      let container = document.getElementById('container');
      return container.classList.remove("right-panel-active")
    },

  },
}).mount('#app')



const inputs = document.querySelectorAll(".input-field");
const toggle_btn = document.querySelectorAll(".toggle");
const main = document.querySelector("main");
const contenedor = document.querySelector('.contenedor_general')
const colores = ['#CB51EE', '#0073BC', '#38B75E', '#DE365C']
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




const figuras = () => {
  for (let i = 0; i <= 35; i++) {
    let figura = document.createElement('span')
    let select = Math.round(colores.length * Math.random())



    figura.style.top = innerHeight * Math.random() + 'px'
    figura.style.left = innerWidth * Math.random() + 'px'
    figura.style.background = colores[select >= colores.length ? select - 1 : select]

    contenedor.appendChild(figura)

    setInterval(() => {
      figura.style.top = innerHeight * Math.random() + 'px'
      figura.style.left = innerWidth * Math.random() + 'px'
    }, 2500)
  }
}

figuras()
