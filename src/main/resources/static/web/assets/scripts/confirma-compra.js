

const app = Vue.createApp({
    data() {
        return {
            productos: [],
            articulosCarrito: [],
            amount: "",
            cliente: "",
            total: 0,
            cardNumber: "",
            cardCvv: "",
            paymentAmount: "",
            paymentDescription: "",
            ciudad: ""
        }



    },

    created() {
        this.loadData("/api/clientes/actual")


    },

    methods: {
        loadData(url) {
            axios.get(url)
                .then(response => {
                    this.cliente = response.data
                    this.productos = response.data.carrito.ordenCompra
                    this.precioTotal = this.productos.map(producto => producto.precio)
                    let total = this.precioTotal.reduce((a, b) => a + b, 0)
                    this.total = total
                    console.log(this.cliente);
                })
                .catch(error => console.log(error))
        },
        agregarProducto(id) {
            axios.patch("/api/agregar", `id=${id}`)
                .then(response => {
                    console.log(response.data)
                    this.productos = response.data
                })
                .catch(error => console.log(error))
        },
        novaPayments() {
            let number = this.cardNumber
            let cvv = this.cardCvv
            let amount = this.paymentAmount
            let description = this.paymentDescription
            let alert = Swal.fire({
                title: '¿Estás seguro?',
                text: "Una vez hecha la transacción no podemos deshacerla",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#24cb24',
                cancelButtonColor: '#ff4545',
                confirmButtonText: 'Yes, I am sure'
            }).then(res => {
                if (res.isConfirmed == true) {
                    return axios.post('https://nova-bank-production-45f5.up.railway.app/api/payments',
                        { number: number, cvv: cvv, amount: this.total + 150, description: description })
                        .then(result => {
                            if (result.status == 201) {
                                return axios.get('/api/pdf/generate')
                                    .then(result => window.location.assign(result.request.responseURL)
                                    )
                                    .catch(error => console.log(error)
                                    )
                            }
                        })
                        .then(() => {
                            return axios.post('/api/transaccional')
                        })
                        .then(result =>
                            Swal.fire({
                                title: 'Pago exitoso',
                                text: "Tu pago se hizo exitosamente",
                                icon: 'success',
                                confirmButtonColor: '#24cb24',
                            })
                        ).then(result =>
                            window.location.assign("./productos.html")
                        ) 
                        .catch(error => Swal.fire({
                            icon: 'error',
                            title: 'Error ' + error.response.status,
                            text: error.response.data,
                            confirmButtonColor: '#ff4545',
                        })
                        )
                }
            })
        },

        pdf() {

        },
        eliminarProducto(e) {
            const productoId = e.target.getAttribute("data-id")
            this.articulosCarrito = this.articulosCarrito.filter(producto => producto.id !== productoId)
            this.sincronizarStorage()
        },


        modificarSaldo(saldo) {
            return new Intl.NumberFormat("en-US", { style: "currency", currency: "USD" }).format(saldo);
        },


        logOut() {
            return axios.post('/api/logout')
                .then(response => window.location.href = "/web/index.html")
        },


        datemodified(date) {
            return new Date(date).toLocaleDateString('es-co', { year: "numeric", month: "short", day: "numeric" })
        },

        cerrarSesion() {
            axios.post('/api/logout').then(response => {
            })
            location.assign("./index.html")
        },



    },
    computed: {
        double_filter() {
            let first_filter = this.backupEVENTS.filter(events => events.name.toLowerCase().includes(this.search_text.toLowerCase()))
            if (this.filtrocategories.length) {
                this.EVENTS = first_filter.filter(events => this.filtrocategories.includes(events.category))
            } else {
                this.EVENTS = first_filter
            }
        },
    },

})
app.mount('#app')


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
$(document).on("click", ".menu-open", function () {
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

	var header = document.getElementById('menu-open');

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


const contenedor = document.querySelector('.contenedor_general')
const colores =['#cc51ee43','#0074bc37','#38b75e4b','#de365d43']

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
        },2500)
    }
}

figuras1()