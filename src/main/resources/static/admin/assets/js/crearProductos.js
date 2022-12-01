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
      restarProducto(id){
        axios.patch("/api/restar",`id=${id}`).then(()=>this.cargarData(this.urlApi))
      },
      agregarProducto(id){
        axios.patch("/api/agregar",`id=${id}`).then(()=>this.cargarData(this.urlApi))
    }
    },
  });
  app.mount("#app");