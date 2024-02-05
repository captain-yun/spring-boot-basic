const form = document.querySelector('#form');
form.addEventListener("click", (e) => {
    e.preventDefault();
    console.log(e.target)
    if (e.target.tagName == 'IMG') {
        let yourInput = e.target.getAttribute('src');
        if (yourInput.includes("rock")) {
            yourInput = 0;
        } else if (yourInput.includes("scissors")) {
            yourInput = 1;
        } else {
            yourInput = 2;
        }

        location.href = `/rsp/play?yourInput=${yourInput}`
    }
});