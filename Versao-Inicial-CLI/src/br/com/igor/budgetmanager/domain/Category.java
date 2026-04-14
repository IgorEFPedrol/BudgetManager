package br.com.igor.budgetmanager.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entidade que classifica a origem ou destino do dinheiro.
 * <p>
 * Esta classe utiliza o padrão de estrutura de dados em árvore (Tree) através
 * de uma auto-referência (parentCategory). Isso elimina a necessidade de herança
 * para subcategorias, permitindo uma hierarquia infinita e dinâmica.
 */
public class Category {

    private Long id;
    private String name;
    private TransactionType type;
    private Category parentCategory;
    private List<Category> subcategories;

    /**
     * Construtor para categorias principais (Raiz).
     * * @param name Nome da categoria (ex: "Alimentação").
     * @param type Tipo de transação associada (INCOME ou EXPENSE).
     */
    public Category(String name, TransactionType type) {
        this.name = name;
        this.type = type;
        this.subcategories = new ArrayList<>();
    }

    /**
     * Adiciona uma subcategoria a esta categoria.
     * <p>
     * Este método garante a integridade bidirecional: ele adiciona a subcategoria
     * na lista local e também configura esta instância como o "pai" da subcategoria.
     * O tipo da subcategoria é herdado obrigatoriamente do pai para evitar inconsistências.
     * * @param childName Nome da nova subcategoria.
     * @return A nova subcategoria instanciada.
     */
    public Category addSubcategory(String childName) {
        Category child = new Category(childName, this.type);
        child.parentCategory = this;
        this.subcategories.add(child);
        return child;
    }

    /**
     * Verifica se esta é uma categoria principal (sem pai).
     * * @return true se for raiz, false caso seja uma subcategoria.
     */
    public boolean isRoot() {
        return this.parentCategory == null;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionType getType() {
        return type;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    /**
     * Retorna uma lista imutável das subcategorias.
     * <p>
     * Boa prática: Retornar Collections.unmodifiableList impede que outras classes
     * adicionem elementos na lista diretamente (ex: category.getSubcategories().add(...)),
     * forçando o uso do método oficial addSubcategory.
     * * @return Lista de subcategorias protegida contra modificações.
     */
    public List<Category> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
