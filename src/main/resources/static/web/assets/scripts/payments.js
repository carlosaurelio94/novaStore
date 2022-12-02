const { createApp } = Vue

createApp({
    data() {
        return {
            cardNumber: "",
            cardCvv: "",
            paymentAmount: "",
            paymentDescription: "",
        }
    },
    created() {
    },
    mounted() {
    },
    methods: {
        cerrarSesion() {
            axios.post('/api/logout').then(response => {
            })
            location.assign("./index.html")
        },
        novaPayments() {
            let number = this.cardNumber
            let cvv = this.cardCvv
            let amount = this.paymentAmount
            let description = this.paymentDescription
            let alert = Swal.fire({
                title: '¿Estás seguro?',
                text: "Una vez hecha la transacción no podemos deshacerla",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#24cb24',
                cancelButtonColor: '#ff4545',
                confirmButtonText: 'Yes, I am sure'
            }).then(res => {
                if (res.isConfirmed == true) {
                    return axios.post('https://nova-bank-production-45f5.up.railway.app/api/payments',
                        { number: number, cvv: cvv, amount: amount, description: description })
                        .then(result => {
                            if (result.status == 201) {
                                return axios.get('/api/pdf/generate')
                            }
                        })
                        .then(result =>
                            Swal.fire({
                                title: 'Pago exitoso',
                                text: "Tu pago se hizo exitosamente",
                                icon: 'success',
                                confirmButtonColor: '#24cb24',
                            })
                        ).then(result =>
                            window.location.assign("./index.html")
                        )
                        .catch(error => Swal.fire({
                            icon: 'error',
                            title: 'Error ' + error.response.status,
                            text: error.response.data,
                            confirmButtonColor: '#ff4545',
                        })
                        )
                }
            })
        },

    },
    computed: {
    }
}).mount('#app')
