//parte 1
const pessoa = {
    saudacao: 'Opa',
    falar() {
        console.log(this.saudacao)
    }
}

pessoa.falar()

const falar = pessoa.falar

falar()

const falarDePessoa = pessoa.falar.bind(pessoa)
falarDePessoa()

//parte 2

const self = this
/*
function Pessoa() {
    this.idade = 0

    setInterval(function() {
        this.idade++
        console.log(this.idade)
    }.bind(this), 1000)
}
*/

function Pessoa() {
    self.idade = 0

    setInterval(function () {
        self.idade++
        console.log(self.idade)
    }, 1000)
}

new Pessoa