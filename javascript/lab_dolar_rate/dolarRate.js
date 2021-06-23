require('dotenv').config({ path: '/Users/lab/code/my-lab/javascript/lab_dolar_rate/.env' })

const axios = require('axios').default;

function dolarRateError(error) {
    const { response: { data: { status, message } } } = error

    throw {
        'status_code': status,
        'message': message
    }
}

async function sendTelegramMessage(message) {
    const baseURL = process.env.TELEGRAM_BASE_URL
    const botToken = process.env.TELEGRAM_BOT_TOKEN
    const chatID = process.env.TELEGRAM_CHAT_ID
    const messagePayload = message.split(' ').join('%20').replace('ç', '%C3%A7').replace('ã', '%C3%A3').replace('ó', '%C3%B3').replace('é', '%C3%A9')
                                  .replace(':', '%3A').replace('$', '%24').replace('.', ',')
    const fullURL = `${baseURL}/bot${botToken}/sendMessage?chat_id=${chatID}&text=${messagePayload}`
    try {
        await axios.post(fullURL)
            .then(() => console.log('Mensagem enviada com sucesso!'))
            .catch(err => console.error(`Houve um erro ao enviar a messagem.\n${err}`))
    } catch (err) {
        console.error(`Houve um erro ao enviar a messagem.\n${err}`)
    }
}


async function consultDolarRate() {
    const baseURL = process.env.RATE_API_URL
    const currency = 'USD-BRL'
    try {
        await axios.get(`${baseURL}/json/last/${currency}`)
            .then((response) => {
                let { USDBRL: { bid: rate } } = response.data
                rate = parseFloat(rate).toFixed(2)
                const message = `A cotação atual do dólar é: R$${rate}`
                sendTelegramMessage(message)
            }).catch((err) => {
                message = 'Não foi possível buscar a cotação!'.split(' ').join('%20').replace('ç', '%C3%A7').replace('ã', '%C3%A3').replace('í', '%C3%AD').replace('!', '%21')
                sendTelegramMessage(message)
                dolarRateError(err)
            })
    } catch (err) {
        console.error(err)
    }

}

consultDolarRate()