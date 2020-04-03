<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Автонарушители</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link rel="stylesheet" href="static/css/style.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Автонарушители</a>
            </div>
            <form class="navbar-form navbar-left" action="#">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Поиск нарушения</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Войти</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Выйти</a></li>
            </ul>
        </div>
    </nav>
</header>
<main>
    <div class="row">
        <div class="panel panel-default right-panel">
            <div class="panel-body">
                <div class="col-md-2">
                    <div class="panel panel-default right-panel">
                        <div class="panel-body">
                            <p>Имя</p>
                            <p>Роль</p>
                            <p>Количество нарушений</p>
                            <p>Требует оплаты</p>
                            <p>Оплачено</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover">
                                <caption>Перечень заявок</caption>
                                <tr>
                                    <th>№ п/п</th>
                                    <th>Статус</th>
                                    <th>Место аварии</th>
                                    <th>Номер машины</th>
                                    <th>Описание нарушения</th>
                                    <th>Фотография</th>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td class="success">Принята</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td class="info">Завершена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td class="danger">Отклонена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td class="danger">Отклонена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td class="danger">Отклонена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td class="danger">Отклонена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td class="danger">Отклонена</td>
                                    <td>Шоссе Энтузиастов 45</td>
                                    <td>ва777па999</td>
                                    <td>Легкое дтп</td>
                                    <td><img class="img-table-wrapper" src="media/img/acident.jpg"></td>
                                </tr>
                            </table>
                        </div>
                        <nav class="text-center" aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<aside role="complementary">
    <!-- Дополнительный контент -->
</aside>
<footer>
    <nav class="navbar navbar-default navbar-fixed-bottom row-fluid">
        <div class="container-fluid">
            <p class="text-center">
                ©dubovitsky.space, 2006-2009. Все материалы данного сайта являются объектами авторского права (в том числе дизайн). Запрещается копирование, распространение (в том числе путем копирования на другие сайты и ресурсы в Интернете) или любое иное использование информации и объектов без предварительного согласия правообладателя.
            </p>
        </div>
    </nav>
</footer>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>