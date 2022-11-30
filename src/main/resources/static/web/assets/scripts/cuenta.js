const { createApp } = Vue

createApp({
    data() {
        return {
            cliente: [],
            compras: [],
            urlApi:"/api/clientes/actual"
        }
    },
    created() {
        this.loadData(this.urlApi)
    },
    mounted() {
    },
    methods: {
        loadData(url) {
            axios
                .get(url)
                .then(res => {
                    this.cliente = res.data
                    this.compras = this.cliente.compras
                    console.log(this.compras);
                })
                .catch(error => {
                    if (error.response.data == "THIS IS NOT YOUR ACCOUNT") {
                        window.location.assign("./accounts.html")
                    }
                }
                )
        },
        mostrarSaldo(id) {
            let cambiar = document.getElementById(id)
            if (cambiar.innerHTML == "*******") {
                let separador = this.balances.filter(bal => bal.id == id)
                cambiar.innerHTML = separador[0].saldo
            }
        },
        modificarFecha(fecha) {
            let fechaNueva = fecha.split("T")
            let fechaOtra = fechaNueva[0].split("-")
            let horaNueva = fechaNueva[1].split(".")
            let horaFinal = horaNueva[0]
            return `${fechaOtra[2]}-${fechaOtra[1]}-${fechaOtra[0]} / ${horaFinal}`
        },
        modificarSaldo(saldo) {
            return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(saldo);
        },
        sumasTotales(balances) {
            let montos = this.transacciones.map(tra => tra.amount)
            let sumaMontos = montos.reduce((a, b) => { return a + b })
            let final = balances + sumaMontos
            return final
        },
        generatePdf() {
            let accountNumber = this.accountNumber
            let dateFrom = this.dateFrom
            let dateTo = this.dateTo
            console.log(accountNumber)
            console.log(typeof dateFrom)
            console.log(typeof dateTo)
            /* return axios.post('/api/pdf/generate', `number=VIN001&dateFrom=2022-11-17&dateTo=2022-11-22`)
                .then(result =>
                    console.log(result)
                )
                .catch(error => console.log(error)
                ) */
            return axios.get('/api/pdf/generate', {
                params: {
                    number: accountNumber,
                    dateFrom: dateFrom,
                    dateTo: dateTo
                }
            }).then(result => window.location.assign(result.request.responseURL)
            )
            .catch(error => console.log(error)
            )
            },
        cerrarSesion() {
            axios.post('/api/logout').then(response => {
                localStorage.setItem("cookie", "false")
            })
            location.reload()
        },
    },
    computed: {
    }
}).mount('#app')
