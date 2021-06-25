function MeuObjeto(){}

console.log(MeuObjeto.prototype)

const ob1 = new MeuObjeto
const ob2 = new MeuObjeto

console.log(ob1.__proto__ === ob2.__proto__)
console.log(MeuObjeto.prototype === ob1.__proto__)

MeuObjeto.prototype.nome = 'Alan'
MeuObjeto.prototype.falar = function () {console.log(`Meu nome é ${this.nome}!`)}

ob1.falar()
ob2.nome = 'Rafael'
ob2.falar()

const ob3 = {}
ob3.__proto__ = MeuObjeto.prototype
ob3.nome = 'obj3'
ob3.falar()