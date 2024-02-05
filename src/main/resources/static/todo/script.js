const todos = document.querySelector('#todos');

form.addEventListener("submit", (e) => {
    e.preventDefault();
    postTodo();
});
async function list() {
    todos.innerHTML = "";
    let res = await fetch("/api/todos");
    let todos_ = await res.json();
    todos_.forEach((todo) => {
        addTodoIntoHtml(todo);
    })
}

function addTodoIntoHtml(todo) {
    let todoText = input.value;

    if (todo) {
        todoText = todo.todo;
    }
    if (todoText) {
        const todoEl = document.createElement("li");
        if (todo && (todo.done == "true")) {
            todoEl.classList.add("completed");
        }
        todoEl.innerText = todoText;
        todoEl.addEventListener("click", (event) => {
            todoEl.classList.toggle("completed");
            toggleCompleted(todo.id);
        });
        todoEl.addEventListener("contextmenu", (e) => {
            e.preventDefault();
            todoEl.remove();
            removeTodo(todo.id);
        });
        todos.appendChild(todoEl);
        input.value = "";
        // updateToServer();
    }
}

function updateToServer() {
    const todosEl = document.querySelectorAll("li");
    const todos = [];
    todosEl.forEach((todoEl) => {
        todos.push({
            text: todoEl.innerText,
            completed: todoEl.classList.contains("completed"),
        });
    });
}

async function postTodo() {
    console.log("나는 먼저 간다1");
    let res = await fetch("/api/todos", {
        method : "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify({
            todo : input.value,
            done : "false",
        })
    });
    console.log(res);
    console.log("나는 먼저 간다2");
    let todo = await res.json();
    // addTodoIntoHtml(todo);
    if (todo != null) {
        list();
    }
    console.log("나는 먼저 간다3");
}

async function toggleCompleted(id) {
    let res = await fetch(`/api/todos/${id}`, {
        method : "PUT"
    });
}

async function removeTodo(id) {
    let res = await fetch(`/api/todos/${id}`, {
        method : "DELETE"
    });
}

list();