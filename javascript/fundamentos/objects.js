const prod1 = {};

prod1.nome = "Celular top";
prod1.preco = "1999.90";
prod1["Desconto Legal"] = 0.4; //evitar espaco

console.log(prod1);

const prod2 = {
  nome: "camisa",
  preco: "12.00",
  obj: {
    prop: 1,
  },
};


console.log(typeof Object)
console.log(typeof new Object())

const Cliente = function() {}
console.log(typeof Cliente)
console.log(typeof new Cliente)

class Produto {}
console.log(typeof Produto)
console.log(typeof new Produto)
