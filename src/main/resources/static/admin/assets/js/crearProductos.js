const app = Vue.createApp({
    data() {
      return {
        info: null,
        urlApi: "/api/productos",
        productos:[],
        imagen:"",
        id:"",
        nombre:"",
        stock:"",
        precio:"",
        talle:"",
      };
    },
    created() {
      this.cargarData(this.urlApi);
    },
    methods: {
      cargarData(url) {
        axios.get(url).then((response) => {
          response;
          this.info = response;
          this.productos = this.info.data;
          console.log(this.id);
        });
      },
    //   logOut() {
    //     axios.post("/api/logout")
    //       .then(() => {Swal.fire('Loan Aproved', '', 'success')
    //       setTimeout(()=>window.location.assign("index.html"),"1500")});
    //   },
      toggleModal(){
        document.body.classList.toggle("open");
      },
      crearProducto(){
        axios.post("/api/producto",`URLImagen=${this.imagen}&nombre=${this.nombre}&stock=${this.stock}&precio=${this.precio}&talle=${this.talle}`).then(()=>this.cargarData(this.urlApi))
      },
      eliminarProducto(id){
        axios.patch("/api/productos",`id=${id}`).then(()=> this.cargarData(this.urlApi))
      },
    },
  });
  app.mount("#app");