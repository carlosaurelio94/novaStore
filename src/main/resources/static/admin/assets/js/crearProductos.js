const app = Vue.createApp({
    data() {
      return {
        info: null,
        urlApi: "/api/productos",
        productos:[],
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
        axios.post("/api/producto",`nombre=${this.Nombre}&stock=${this.stock}&precio=${this.precio}&talle=${this.talle}`)
      },
      eliminarProducto(){
        axios.patch("/api/restar",`id=${this.id}`)
      }

    },
  });
  app.mount("#app");