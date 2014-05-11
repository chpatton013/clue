/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author bennettschalich
 */
public class SuspectCard extends HintCard
{
    private SuspectID suspect;
    
    public SuspectCard(SuspectID suspect)
    {
        super(HintCardType.SUSPECT);
        this.suspect = suspect;
    }
    
    public SuspectID getSuspect()
    {
        return suspect;
    }
}
