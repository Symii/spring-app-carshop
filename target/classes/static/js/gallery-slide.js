let currentIndex = 0;
const images = document.querySelectorAll('.gallery-images img');
const totalImages = images.length;
function nextSlide() {
    currentIndex = (currentIndex + 1) % totalImages;
    updateGallery();
}

function prevSlide() {
    currentIndex = (currentIndex - 1 + totalImages) % totalImages;
    updateGallery();
}

function updateGallery() {
    const offset = -currentIndex * 500; // 500px to szerokość obrazu
    document.querySelector('.gallery-images').style.transform = `translateX(${offset}px)`;
}
