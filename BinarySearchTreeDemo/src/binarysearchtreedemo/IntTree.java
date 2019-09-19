/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreedemo;


public class IntTree
{
    private static class IntTreeNode
    {
        private int data;
        private IntTreeNode leftLink;
        private IntTreeNode rightLink;

        public IntTreeNode(int newData, IntTreeNode newLeftLink,
                                        IntTreeNode newRightLink)
        {
             data = newData;
             leftLink = newLeftLink;
             rightLink = newRightLink;
        }
    } //End of IntTreeNode inner class


    private IntTreeNode root;

    public IntTree( )
    {
        root = null;
    }

    public void add(int item)
    {
        root = insertInSubtree(item, root);
    }

    public boolean contains(int item)
    {
        return isInSubtree(item, root);
    }

    public void showElements( )
    {
        showElementsInSubtree(root);
    }

    /**
     Returns the root node of a tree that is the tree with root node
     subTreeRoot, but with a new node added that contains item.
    */
    private static IntTreeNode insertInSubtree(int item, 
                                          IntTreeNode subTreeRoot)
    {
        if (subTreeRoot == null)
            return new IntTreeNode(item, null, null);
        
        IntTreeNode node = subTreeRoot;
        IntTreeNode parent = null;
        while(node != null)
        {
            parent = node;
            if(item < node.data)
            {
                node = node.leftLink;
            }
            else
            {
                node = node.rightLink;
            }
        }
        
        if(item < parent.data)
        {
            parent.leftLink = new IntTreeNode(item, null, null);
        }
        else
        {
            parent.rightLink = new IntTreeNode(item, null, null);
        }
        
        return subTreeRoot;
    }

    private static boolean isInSubtree(int item, IntTreeNode subTreeRoot)
    {
        IntTreeNode node = subTreeRoot;
        while(node != null)
        {
            if(item == node.data)
            {
                return true;
            }
            else if(item < node.data)
            {
                node = node.leftLink;
            }
            else
            {
                node = node.rightLink;
            }
        }
        
        return false;
    }

    private static void showElementsInSubtree(IntTreeNode subTreeRoot)
    {//Uses inorder traversal.
        if (subTreeRoot != null)
        {
            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.print(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }//else do nothing. Empty tree has nothing to display.
    }
    
    public void preorderElements()
    {
        preorder(root);
    }

    private static void preorder(IntTreeNode subTreeRoot)
    {//Uses preorder traversal.
        if (subTreeRoot != null)
        {
            System.out.print(subTreeRoot.data + " ");
            preorder(subTreeRoot.leftLink);
            preorder(subTreeRoot.rightLink);
        }//else do nothing. Empty tree has nothing to display.
    }
    
    public void postorderElements()
    {
        postorder(root);
    }
    
    private static void postorder(IntTreeNode subTreeRoot)
    {//Uses postorder traversal.
        if (subTreeRoot != null)
        {
            postorder(subTreeRoot.leftLink);
            postorder(subTreeRoot.rightLink);
            System.out.print(subTreeRoot.data + " ");
        }//else do nothing. Empty tree has nothing to display.
    }
}