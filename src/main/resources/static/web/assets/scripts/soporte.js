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



