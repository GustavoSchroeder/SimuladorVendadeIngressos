package simuladorvendadeingressos.listaencadeada;

/**
 *
 * @author Gustavo
 */
public class Node<E> {
      protected E element;
      protected Node<E> next;
      
      public Node(E element){
          this.element = element;
          this.next = null;
      }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }
      
      
}

