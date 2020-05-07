package com.nal.others.trie;

/**
 * Created by nishant on 06/04/20.
 * https://www.geeksforgeeks.org/implement-a-phone-directory/
 * Implement a Phone Directory
 * Given a list of contacts which exist in a phone directory. The task is to implement search query for the phone directory. The search query on a string ‘str’ displays all the contacts which prefix as ‘str’. One special property of the search function is that, when a user searches for a contact from the contact list then suggestions (Contacts with prefix as the string entered so for) are shown after user enters each character.
 * Note : Contacts in the list consist of only lower case alphabets.
 */
public class ContactsUsingTrie {

    private static final int ALPHABET_SIZE = 26;

    class TrieNode {
        boolean isEndOfWord;
        int count;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        public TrieNode() {
            isEndOfWord = false;
            count = 0;
        }
    }

    TrieNode root;

    public ContactsUsingTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        curr.count++;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr.children[index].count++;
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public int countWithPrefix(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.count;
    }

    public static void main(String[] args) {
        ContactsUsingTrie contacts = new ContactsUsingTrie();
        contacts.insert("cat");
        contacts.insert("catlin");
        contacts.insert("the");
        contacts.insert("there");
        contacts.insert("these");
        contacts.insert("those");
        System.out.println(contacts.countWithPrefix(""));
        System.out.println(contacts.countWithPrefix("cat"));
        System.out.println(contacts.countWithPrefix("th"));
        System.out.println(contacts.countWithPrefix("the"));
    }
}
