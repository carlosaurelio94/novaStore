const app = Vue.createApp({
    data() {
      return {
        info: null,
        urlApi: "/api/clientes",
        clientes: [],
        id:"",
        imagen:"",
        Nombre:"",
        Apellido:"",
        Correo:"",
        Clave:"",
        Clave2:"",
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
          this.clientes = this.info.data;
        console.log(this.id);
        });
      },
    //   logOut() {
    //     axios.post("/api/logout")
    //       .then(() => {Swal.fire('Loan Aproved', '', 'success')
    //       setTimeout(()=>window.location.assign("index.html"),"1500")});
    //   },
      
      crearCliente(){
        axios.post("/api/clientes",`nombre=${this.Nombre}&apellido=${this.Apellido}&correo=${this.Correo}&clave=${this.Clave}&clave2=${this.Clave2}`)
      },
      eliminarCliente(id){
        axios.patch("/api/clientes",`id=${id}`).then(()=>this.cargarData(this.urlApi))
      }

    },
  });
  app.mount("#app");