// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2019
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.controller.hui.command.trigger;

import de.mossgrabers.controller.hui.HUIConfiguration;
import de.mossgrabers.controller.hui.controller.HUIControlSurface;
import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.daw.IModel;
import de.mossgrabers.framework.utils.ButtonEvent;


/**
 * Command for the zoom button.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class ZoomCommand extends AbstractTriggerCommand<HUIControlSurface, HUIConfiguration>
{
    /**
     * Constructor.
     *
     * @param model The model
     * @param surface The surface
     */
    public ZoomCommand (final IModel model, final HUIControlSurface surface)
    {
        super (model, surface);
    }


    /** {@inheritDoc} */
    @Override
    public void execute (final ButtonEvent event)
    {
        if (event == ButtonEvent.DOWN)
            this.surface.getConfiguration ().toggleZoomState ();
    }
}