// aula1
let dobro = function (a) {
    return a * 2
}

dobro = (a) => {return a * 2}

dobro = a => a * 2 // return implicito
console.log(dobro(Math.PI))

let ola = function () {
    return 'Olá'
}

ola = () => 'Olá'
ola = _ => 'Olá' //possui parametro, mas pode ser ignorado
console.log(ola())

// aula2
// function Pessoa() {
//     this.idade = 0

//     setInterval(() => {
//         this.idade++
//         console.log(this.idade)
//     }, 1000)
// }

// new Pessoa

// aula3
let comparaComThis = function (param) {
    console.log(this === param)
}

comparaComThis(global)

const obj = {}
comparaComThis = comparaComThis.bind(obj)
comparaComThis(global)
comparaComThis(obj)

let comparaComThisArrow = param => console.log(this === param)
comparaComThisArrow(global)
comparaComThisArrow(module.exports)
comparaComThisArrow(this)

comparaComThisArrow = comparaComThisArrow.bind(obj)
comparaComThisArrow(obj)
comparaComThisArrow(module.exports)