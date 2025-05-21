document.addEventListener('DOMContentLoaded', () => {
    const menuCheckbox = document.getElementById('menu');
    const navbar = document.querySelector('.navbar');

    menuCheckbox.addEventListener('change', () => {
        if (menuCheckbox.checked) {
            navbar.style.display = 'flex';
        } else {
            navbar.style.display = 'none';
        }
    });
});
