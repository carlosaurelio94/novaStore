const app = Vue.createApp({
    data() {
        
    

   
    },

    methods: {
        
        logOut() {
            return axios.post('/api/logout')
                .then(response => window.location.href = "/web/index.html")
        },


        datemodified(date) {
            return new Date(date).toLocaleDateString('es-co', { year: "numeric", month: "short", day: "numeric" })
        },

        alerta(){
			const Toast = Swal.mixin({
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
				  toast.addEventListener('mouseenter', Swal.stopTimer)
				  toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			  })
			  
			  Toast.fire({
				icon: 'success',
				title: 'Consulta enviada!'
			  }).then(()=> window.location.reload())
		}
    },
    computed: {
        
},

})
app.mount('#app')


const contenedor = document.querySelector('.contenedor_general')
const colores =['#CB51EE','#0073BC','#38B75E','#DE365C']

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
        },5000)
    }
}

figuras()

const contenedor1 = document.querySelector('.contenedor_general1')


const figuras1 = () =>{
    for(let i= 0; i <= 35; i++){
        let figura = document.createElement('span')
        let select = Math.round(colores.length * Math.random())

        figura.style.top = innerHeight*Math.random() + 'px'
        figura.style.left = innerWidth*Math.random() + 'px'
        figura.style.background = colores[select >= colores.length ?  select -1: select]

        contenedor1.appendChild(figura)

        setInterval(() =>{
            figura.style.top = innerHeight*Math.random() + 'px'
            figura.style.left = innerWidth*Math.random() + 'px'
        },5000)
    }
}

figuras1()


var t1 = new TimelineMax({ paused: true });

t1.to(".nav-container", 1, {
	left: 0,
	ease: Expo.easeInOut,

});

t1.staggerFrom(
	".menu > div",
	0.8,
	{ y: 100, opacity: 0, ease: Expo.easeOut },
	"0.1",
	"-=0.4"
);

t1.staggerFrom(
	".socials",
	0.8,
	{ y: 100, opacity: 0, ease: Expo.easeOut },
	"0.4",
	"-=0.6"
);

t1.reverse();
$(document).on("click", "#menu-open", function () {
	t1.reversed(!t1.reversed());
});
$(document).on("click", ".menu-close", function () {
	t1.reversed(!t1.reversed());
});


function hideHeader () {

	
	var doc = document.documentElement;
	var w = window;

	

	

	var curScroll = prevScroll = w.scrollY || doc.scroll(top);
	var curDirection = prevDirection = 0;

	var header = document.getElementById('menu-open_container');

	function checkScroll(){
		curScroll = window.scrollY || doc.scroll(top)
		if(curScroll > prevScroll){
			curDirection = 2;
		}
		else{
			curDirection = 1;
		}

		if (curDirection !== prevDirection) {
			toggleHeader();
		}

		prevDirection = curDirection;
		prevScroll = curScroll;

	}

	function toggleHeader(){

		if (curDirection === 2) {
			header.classList.add('hide');
		}		

		else if (curDirection === 1){
			header.classList.remove('hide');
		}
	}

	w.addEventListener('scroll', checkScroll)

}


hideHeader()



