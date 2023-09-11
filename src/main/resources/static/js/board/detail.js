var path = window.location.pathname;
var segments = path.split('/');
var boardId = segments[segments.length - 1];

function init() {
    detail();
    eventBinding();
}

function detail() {
    $.ajax({
        url: '/board/api/detail/' + boardId,
        type: 'GET',
        data: $('#detailForm').serialize(),
        success: function (response) {
            var board = response;
            if (board != null) {
                setBoardData(board);
            } else {
                $('#datatable tbody').append('데이터가 없습니다.')
            }
        }
    })
}

function setBoardData(board) {
    $('#boardId').text(board.boardId)
    $('#writer').text(board.writer)
    $('#title').text(board.title)
    $('#content').text(board.content)
    $('#button').text(board.content)
}

function eventBinding() {
    /* 수정 버튼 이벤트 등록 */
    var editButton = document.getElementById("editButton");

    editButton.addEventListener("click", function () {
        window.location.href = "/board/edit?boardId=" + boardId;
    });
}