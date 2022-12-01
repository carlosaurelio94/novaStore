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
          Swal.fire({
          title: 'Está seguro?',
          text: "Se eliminara el cliente seleccionado",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33', 
          cancelButtonText: 'Cancelar',
          confirmButtonText: 'Si, eliminar el usuario!'
        }).then( (result) => {
          if (result.isConfirmed) {
            axios.patch("/api/clientes",`id=${id}`).then(()=>this.cargarData(this.urlApi))
            console.log("eliminado")
            Swal.fire(
              'Eliminado!',
              'Se ha eliminado el cliente',
              'success', 
         )
            }
        })
        
      },
      alerta(){
        Swal.fire({
          title: 'Está seguro?',
          text: "Se creará un usuario con los datos ingresados",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33', 
          cancelButtonText: 'Cancelar',
          confirmButtonText: 'Si, crear el usuario!'
        }).then((result) => {
          if (result.isConfirmed) {
            Swal.fire(
              'Creado!',
              'Se ha enviado un correo de confirmacion a su email',
              'success', 
              axios.post("/api/clientes",`nombre=${this.Nombre}&apellido=${this.Apellido}&correo=${this.Correo}&clave=${this.Clave}&clave2=${this.Clave2}`)
            ).then(()=> location.reload())
          }
        })
      },
      
    },
  });
  app.mount("#app");