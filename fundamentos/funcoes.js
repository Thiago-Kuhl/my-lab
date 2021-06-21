//Funcao sem retorno
function imprimirSoma(a, b) {
  console.log(a + b);
}

imprimirSoma(2, 3);
imprimirSoma(2);
imprimirSoma(2, 10, 2, 34, 56, 2);
imprimirSoma();

// Funcao com retorno
function soma(a = 0, b = 0) {
  return a + b;
}

console.log(soma(2, 3));
console.log(soma(2));

////////////////////////////////////////////////////////////////

//Armazenando funcao na variavel

const imprimirSoma1 = function (a, b) {
  console.log(a + b);
};

imprimirSoma1(2, 3);

// Armazenando uma funcao arrow em uma variavel

const soma1 = (a, b) => {
  return a + b;
};

console.log(soma1(2, 31));

// retorno implicito
const subtracao = (a, b) => a - b;

console.log(subtracao(1, 2))

const imprimir2 = a => console.log(a)

imprimir2(1)