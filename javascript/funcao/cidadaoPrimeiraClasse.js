// Funçao em JS é First-Class Object
// High order function

// criar de forma literali

function fun1() {}

// armazenar em um variável
const fun2 = function () {}

// armazenar dentro de um array
const array = [function (a,b) {return a + b}, fun1, fun2]

console.log(array[0](2,3))

//armazenar atributo ede objeto
const obj = {}
obj.falar = function () {return 'Opa'}
console.log(obj.falar())

//passar como parametro
function run(fun) {
    fun()
}

run(function () {console.log('Executando.....')})

//uma funcao pode retornar / conter uma funcao
function soma(a,b) {
    return function (c) {
        console.log(a + b + c)
    }
}

soma(2,3)(4)
const cincoMais = soma(2,3)
cincoMais(4)