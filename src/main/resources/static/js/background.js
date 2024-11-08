// Lista de URLs das imagens de background
const backgrounds = [
    '/images/backgrounds/background1.jpg',
    '/images/backgrounds/background2.jpg',
    '/images/backgrounds/background3.jpg',
    '/images/backgrounds/background4.jpg',
    '/images/backgrounds/background5.jpg'
];

// Seleciona o contêiner do background
const backgroundContainer = document.querySelector('.background-container');

// Variável de índice para acompanhar qual imagem está sendo exibida
let currentBackgroundIndex = 0;

// Função para alternar o background
function changeBackground() {
    // Atualiza o background do container
    backgroundContainer.style.backgroundImage = `url(${backgrounds[currentBackgroundIndex]})`;

    // Incrementa o índice para a próxima imagem, voltando ao início se necessário
    currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
}

// Inicia a troca de background a cada 5 segundos (5000 ms)
setInterval(changeBackground, 5000);

// Chama a função uma vez para definir o primeiro background imediatamente
changeBackground();