const { createApp } = Vue

createApp({
	data() {
		return {
			usuario: "",
			password: "",
			email: "",
			passwordRegistro: "",
			nombre: "",
			apellido: "",
			password2: ""
		}
	},
	created() {

	},
	mounted() {
	},
	methods: {
		iniciarSesion() {
			let email = this.usuario.toLowerCase();
			let password = this.password
			return axios.post('/api/login', `correo=${email}&clave=${password}`)
				.then(response => {
					localStorage.setItem("cookie", "true")
					window.location.assign("./cuenta.html")
				})
				.catch(function (error) {
					return Swal.fire({
						icon: "error",
						title: "Error " + error.response.status,
						text: "Your email or password are incorrect. Try again",
						confirmButtonColor: '#ff4545',
						footer: '<a href="">Why do I have this issue?</a>'
					})
				})
		},
		registrarse() {
            let email = this.email.toLowerCase()
            let password = this.passwordRegistro
            let nombre = this.nombre.toLowerCase()
            let apellido = this.apellido.toLowerCase()
			let password2 = this.password2
            return axios.post('/api/clientes', `nombre=${nombre}&apellido=${apellido}&correo=${email}&clave=${password}&clave2=${password2}`)
/*                 .then(response => axios.post('/api/login', `email=${email}&password=${password}`))
 */                .then(res => {
                    localStorage.setItem("cookie", "true")
                })
                .then(response => Swal.fire({
                    text: 'Succesful Registration',
                    title: 'Welcome to Nova Bank',
                    icon: 'success',
                    confirmButtonColor: '#24cb24',
        }))
                .then(response => window.location.assign("./accounts.html"))
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
		cerrarSesion() {
			axios.post('/api/logout').then(response => {
				localStorage.setItem("cookie", "false")
			})
			location.reload()
		},
	},
	computed: {
	}
}).mount('#app')













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
login1.addEventListener('click', function () {
	document.getElementById('ingreso_lateral').classList.toggle('activo');

});




const login2 = document.querySelector('.registrarse')
login2.addEventListener('click', function () {
	document.getElementById('ingreso_lateral2').classList.toggle('activo');
});

function verificarPasswords() {
	password1 = document.getElementById('password1');
	password2 = document.getElementById('password2');

	if (password1.value != password2.value) {
		document.getElementById('error').classList.add('mostrar');
		return false;
	} else {
		document.getElementById('error').classList.remove('mostrar');
		document.getElementById('ok').classList.remove('ocultar');
		document.getElementById('crear').disabled = true;
		return true;
	}


}

