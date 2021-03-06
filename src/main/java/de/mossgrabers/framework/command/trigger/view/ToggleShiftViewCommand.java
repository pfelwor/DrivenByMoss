// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2019
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.command.trigger.view;

import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.configuration.Configuration;
import de.mossgrabers.framework.controller.IControlSurface;
import de.mossgrabers.framework.daw.IModel;
import de.mossgrabers.framework.utils.ButtonEvent;
import de.mossgrabers.framework.view.ViewManager;
import de.mossgrabers.framework.view.Views;


/**
 * Command to show/hide the shift view. Additionally, toggles the knob speed.
 *
 * @param <S> The type of the control surface
 * @param <C> The type of the configuration
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class ToggleShiftViewCommand<S extends IControlSurface<C>, C extends Configuration> extends AbstractTriggerCommand<S, C>
{
    /**
     * Constructor.
     *
     * @param model The model
     * @param surface The surface
     */
    public ToggleShiftViewCommand (final IModel model, final S surface)
    {
        super (model, surface);
    }


    /** {@inheritDoc} */
    @Override
    public void execute (final ButtonEvent event)
    {
        if (event == ButtonEvent.LONG)
            return;

        final ViewManager viewManager = this.surface.getViewManager ();
        if (event == ButtonEvent.DOWN && !viewManager.isActiveView (Views.VIEW_SHIFT))
            viewManager.setActiveView (Views.VIEW_SHIFT);
        else if (event == ButtonEvent.UP && viewManager.isActiveView (Views.VIEW_SHIFT))
            viewManager.restoreView ();

        this.model.getValueChanger ().setSpeed (this.surface.isShiftPressed ());
    }
}
