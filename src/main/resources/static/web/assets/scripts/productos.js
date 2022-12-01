const app = Vue.createApp({
    data() {
        return{
           productos:[],
           articulosCarrito: [],
           amount: 200,
           unidades:"",
           buscar:"",
        }
    

   
    },

    created(){
        this.loadData("/api/productos")
        
        
    },

    methods: {
        loadData(url){
            axios.get(url)
            .then(response=>{
                console.log(response.data)
                this.productos = response.data
            })
            .catch(error=>console.log(error))
        },

        carrito(){
            return axios.get("/api/clientes/actual/carrito")
            .then(response=>{
                this.articulosCarrito = response.data.ordenCompra
                console.log(this.articulosCarrito);
            })
            .catch(error=>console.log(error))
        },

        agregarProducto(id){
            axios.patch("/api/agregar",`id=${id}`)
            .then(response=>{
                console.log(response.data)
                this.productos = response.data
            })
            .catch(error=>console.log(error))
        },
        

        eliminarProducto(e){
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
        filtro_texto() {
           return this.productos.filter(producto=> producto.nombre.toLowerCase().includes(this.buscar.toLowerCase()))
            }       
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

const carrito = document.querySelector('.carrito')
carrito.addEventListener('click',function(){
   document.getElementById('carrito_lateral').classList.toggle('activo');   
  
});

