$(function () {
    init();
    eventBinding();
});

function init() {
    search();
}

function eventBinding() {
    $("#title, #writer").on("keyup",function(key){
        if(key.keyCode == 13) {
            search();
        }
    })

    $('#searchBtn').on('click', function () {
        search();
    })

    $('#createBtn').on('click', function () {
        location.href='/board/create';
    })
}

function search() {
    deleteData();

    $.ajax({
        url: '/board/api/list',
        type: 'POST',
        data: $('#searchForm').serialize(),
        success: function (response) {
            var boardList = response.content;
            if (boardList != null && boardList.length > 0) {
                setData(boardList);
            } else {
                alert("데이터가 없습니다.")
                setData([]);
            }
        },
        error: function (xhr) {
            alert(xhr.responseText);
        }
    })
}

function deleteData() {
    $('#datatable tbody').empty();
}

function setData(boardList) {
    $('#datatable tbody').append(makeHtml(boardList))

    $(".detailButton").click(function () {
        var boardId = $(this).data("boardId");
        console.log(boardId);
        window.location.href = "/board/detail/" + boardId;
    });
}

function makeHtml(boardList) {
    var html = "";

    for(var i = 0; i < boardList.length; i++) {
        html += template(boardList[i]);
    }
    return html;
}

function template(board) {
    var template = '';

    template += '<tr>';
    template += '   <td>' + board.boardId + '</td>';
    template += '   <td>' + board.title +'</td>';
    template += '   <td>' + board.writer +'</td>';
    template += '   <td><button class="detailButton" data-board-id="' + board.boardId + '">상세</button></td>';
    template += '<tr/>';

    return template;
}