const app = Vue.createApp({
    data() {
        
    

   
    },

    created(){
        this.loaddata();
    },

    methods: {
        loaddata(){
            axios.get("/api/prueba")
            .then(response=>{
                console.log(response)
            })
            .catch(error=>console.log(error))
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

window.onload=function(){
    slidedos();
    slideuno();

}

let slideruno=document.getElementById("slider-1");
let sliderdos=document.getElementById("slider-2");

let displayvaloruno=document.getElementById("range1")
let displayvalordos=document.getElementById("range2")


let mingap=1000;

let slidertrack=document.querySelector(".slider-track");

let slidervalormaximo = document.getElementById("slider-1").max;


function slideuno(){
    if(parseInt(sliderdos.value)-parseInt(slideruno.value)<=mingap){
        slideruno.value = parseInt(sliderdos.value)-mingap;
    }
    displayvaloruno.textContent=slideruno.value;
    fillColor();
}

function slidedos(){
    if(parseInt(sliderdos.value)-parseInt(slideruno.value)<=mingap){
        sliderdos.value = parseInt(slideruno.value)+mingap;
    }
    displayvalordos.textContent= sliderdos.value;
    fillColor();
}

function fillColor(){
    percent1 = (slideruno.value / slidervalormaximo) * 100;
    percent2 = (sliderdos.value/slidervalormaximo) * 100;
    slidertrack.style.background=`linear-gradient(to-right, #dadae5 ${percent1}% , #3264fe ${percent1}% , #3264fe${percent2}% , #dadae5 ${percent2}%)`;
         /* console.log(slidertrack.style.background) */
}

