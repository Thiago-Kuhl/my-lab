console.log(Math.ceil(6.1))

const obj1 = {}
obj1.name = 'Bola'

console.log(obj1)

function Obj(name) {
    this.name = name
    this.exec = function() {
        console.log('Exec.....')
    }
}

const obj2 = new Obj('cadeira')
const obj3 = new Obj('mesa')

console.log(obj2.name)
console.log(obj3.name)
obj3.exec()