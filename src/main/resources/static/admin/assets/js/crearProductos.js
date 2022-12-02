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
        Swal.fire({
        title: 'Está seguro?',
        text: "Se eliminara el producto seleccionado",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33', 
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Si, eliminar el producto!'
      }).then( (result) => {
        if (result.isConfirmed) {
          axios.patch("/api/productos",`id=${id}`).then(()=>this.cargarData(this.urlApi))
          console.log("eliminado")
          Swal.fire(
            'Eliminado!',
            'Se ha eliminado el producto',
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
              axios.post("/api/producto",`URLImagen=${this.imagen}&nombre=${this.nombre}&stock=${this.stock}&precio=${this.precio}&talle=${this.talle}`).then(()=>this.cargarData(this.urlApi))
            ).then(()=> location.reload())
          }
        })
      },
    },
  });
  app.mount("#app");