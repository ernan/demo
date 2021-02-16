function addRowHandlers() {
	var table = document.getElementById("person-list");
	var rows = table.getElementsByTagName("tr");
	for (i = 0; i < rows.length; i++) {
		var currentRow = table.rows[i];
		var createClickHandler = function(row) {
			return function() {
				var cid = row.getAttribute("row_id");
				window.location.href = "/individual?id=" + cid;
			};
		}
		currentRow.onclick = createClickHandler(currentRow);
	}
}
