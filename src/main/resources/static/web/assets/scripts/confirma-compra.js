/* const contenedor = document.querySelector('.contenedor_general')
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

figuras() */

const app = Vue.createApp({
    data() {
        return {
            productos: [],
            articulosCarrito: [],
            amount: "",
        }



    },

    created() {
        this.loadData("/api/clientes/actual/carrito")


    },

    methods: {
        loadData(url) {
            axios.get(url)
                .then(response => {
                    this.productos = response.data.ordenCompra
                    console.log(this.productos)
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