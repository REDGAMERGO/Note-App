<#import "parts/common.ftlh" as c>

<@c.page>


    <!--Раздел категорий-->
    <table class="table table-bordered" >
        <thead>
            <tr>
                <th>Категория</th>
                <th>Пользователь</th>
            </tr>
        </thead>
        <tbody>
                <#list categories as category>
                    <tr>
                        <td> ${category.getName()}</td>
                        <td> ${category.getAuthor().getUsername()}</td>
                    </tr>
                <#else>
                        No notes
                </#list>
        <tbody>
    </table>

<br>
    <div>
        <form method="post" action="addCategory">
            <input type="text" name="name" placeholder="Введите название" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>


    <!--Раздел заметок-->
    <br>

    <table class="table table-bordered" >
        <tr>
            <th>Текст</th>
            <th>Категория</th>
            <th>Пользователь</th>
            <th>Дата</th>
        </tr>
        <tr>
            <#list notes as note>
                <tr>
                    <td>${note.getText()}</td>
                    <td>${note.category.getName()}</td>
                    <td>${note.getAuthor().getUsername()}</td>
                    <td>${note.getTime()}</td>
                </tr>
            <#else>
                    No notes
            </#list>

        </tr>
    </table>

    <br>
    <div>
        <form method="post" action="addNote">
            <input type="text" name="text" placeholder="Текст заметки" />

            <tr>
                <td>
                    <select name="category" required>
                            <#list categories! as category>
                                <option value="${category.getId()}">
                                    "${category.getName()}"
                                </option>
                            </#list>
                    </select>
                </td>
            </tr>

            <!--<input type="text" name="category" placeholder="Категория">-->
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>


</@c.page>