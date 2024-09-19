document.getElementById("picoPlacaForm").onsubmit = async function(event) {
    event.preventDefault();

    const plate = document.getElementById("plate").value;
    const date = document.getElementById("date").value;
    const hour = document.getElementById("hour").value;

    const response = await fetch("/api/verificar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            plate: plate,
            date: date,
            hour: parseInt(hour)
        })
    });

    const result = await response.json();
    document.getElementById("resultado").textContent = result.message;
}