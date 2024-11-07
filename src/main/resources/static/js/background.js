async function loadBackgroundImages() {
    const response = await fetch('/api/backgrounds');
    return await response.json();
}

 function rotateBackgrounds(images, interval = 10000) {
    let currentIndex = 0;
    document.body.style.backgroundImage = `url(${images[currentIndex]})`;

    setInterval(() => {
        currentIndex = (currentIndex + 1) % images.length;
        document.body.style.backgroundImage = `url(${images[currentIndex]})`;
    }, interval);
}

loadBackgroundImages().then(images => rotateBackgrounds(images));