package space.dubovitsky.intruder.model;

public interface AbstractModelWithPhoto { //! Этот интерфейс нужен для того, чтобы каждая сущность у которой есть фото могла использовать ControllerUtils для избежания дублирования кода

    void setPhoto(String photo);

}
