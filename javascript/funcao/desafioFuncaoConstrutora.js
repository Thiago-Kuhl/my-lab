function Pessoa(nome){
    this.nome = nome
    this.falar = () => console.log(`Meu nome é ${this.nome}`)

}

const p1 = new Pessoa('Thiago')
p1.falar()
