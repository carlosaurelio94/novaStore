const app = Vue.createApp({
    data() {
      return {
        info: null,
        urlApi: "/api/clientes",
        clientes: [],
        id:"",
        Nombre:"",
        Apellido:"",
        Correo:"",
        Clave:"",
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
      toggleModal(){
        document.body.classList.toggle("open");
      },
      crearCliente(){
        axios.post("/api/cliente",`nombre=${this.Nombre}&apellido=${this.Apellido}&correo=${this.Correo}&clave=${this.Clave}`)
      },
      eliminarCliente(){
        // axios.path("/api/clientes",`id=${this.id}`)
        console.log(this.id)
      }

    },
  });
  app.mount("#app");